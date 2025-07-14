package io.shnflrsc.chimer.character;

import org.dizitart.no2.collection.Document;
import java.util.HashMap;

public class BuildUtils {
    @SuppressWarnings("unchecked")
    static HashMap<String, Object> getMap(Document doc, String key) {
        return (HashMap<String, Object>) doc.get(key, HashMap.class);
    }
}
