package io.shnflrsc.chimer.character;

import org.dizitart.no2.collection.Document;
import org.dizitart.no2.collection.DocumentCursor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static io.shnflrsc.chimer.character.CharacterUtils.getMap;

@Service
public class CharacterService {
    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<Character> getAllCharacters() {
        DocumentCursor cursor = repository.getAllCharacters();
        List<Character> characters = new ArrayList<>();

        for (Document doc : cursor) {
            characters.add(new Character (
                    doc.getId().toString(),
                    doc.get("timestamp", LocalDateTime.class),
                    doc.get("name", String.class),
                    doc.get("description", String.class),
                    getMap(doc, "properties")
            ));
        }

        return characters;
    }

    public Character create(Character createdCharacter) {
        return repository.create(createdCharacter);
    }
}
