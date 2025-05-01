package com.jordanbunke.json;

import static com.jordanbunke.json.JSONConstants.*;

public record JSONPair(String key, Object value) {

    public String write() {
        return QUOTE + key + QUOTE + K_V_SEP + " " + writeValue();
    }

    private String writeValue() {
        if (value instanceof String s)
            return QUOTE + s + QUOTE;

        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return write();
    }
}
