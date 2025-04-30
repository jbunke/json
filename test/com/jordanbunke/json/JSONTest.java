package com.jordanbunke.json;

import com.jordanbunke.delta_time.io.FileIO;
import com.jordanbunke.delta_time.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;

public class JSONTest {
    @Test
    public void jsonTest() {
        final String contents = read(Path.of("test-json.json"));

        final JSONPair[] parsed = JSONReader.readObject(contents);
        final JSONBuilder builder = new JSONBuilder();

        if (parsed != null)
            for (JSONPair pair : parsed)
                builder.add(pair);

        Assert.assertEquals(
                removeWhitespace(builder.write()),
                removeWhitespace(contents));
    }

    private static String removeWhitespace(final String contents) {
        return contents.replaceAll("\\s", "");
    }

    private static String read(final Path resource) {
        return FileIO.readResource(ResourceLoader.loadResource(resource), "");
    }
}
