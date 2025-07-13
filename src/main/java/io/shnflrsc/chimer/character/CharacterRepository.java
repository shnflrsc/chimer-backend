package io.shnflrsc.chimer.character;

import io.shnflrsc.chimer.database.Database;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.collection.Document;
import org.dizitart.no2.collection.DocumentCursor;
import org.dizitart.no2.collection.NitriteCollection;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterRepository {
    private final Nitrite db;

    public CharacterRepository(Database database) {
        db = database.connect();
    }

    public DocumentCursor getAllCharacters() {
        try (
                NitriteCollection characters = db.getCollection("characters");
                ) {
            return characters.find();
        }
    }

    public Character create(Character createdCharacter) {
        try (
                NitriteCollection characters = db.getCollection("characters");
                ) {
            Document character = Document.createDocument("timestamp", createdCharacter.timestamp())
                    .put("name", createdCharacter.name())
                    .put("description", createdCharacter.description())
                    .put("properties", createdCharacter.properties());

            return createdCharacter;
        }
    }
}
