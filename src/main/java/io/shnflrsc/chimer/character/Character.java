package io.shnflrsc.chimer.character;

import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDateTime;
import java.util.HashMap;

public record Character (
        @JsonView(CharacterViews.Public.class)
        String id,

        @JsonView(CharacterViews.Public.class)
        LocalDateTime timestamp,

        @JsonView(CharacterViews.Public.class)
        String name,

        @JsonView(CharacterViews.Public.class)
        String description,

        @JsonView(CharacterViews.Public.class)
        HashMap<String, Object> properties
) {}

