package io.shnflrsc.chimer.build;

import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDateTime;
import java.util.HashMap;

public record Build(
        @JsonView(BuildViews.Public.class)
        String id,

        @JsonView(BuildViews.Public.class)
        LocalDateTime timestamp,

        @JsonView(BuildViews.Public.class)
        String name,

        @JsonView(BuildViews.Public.class)
        String description,

        @JsonView(BuildViews.Public.class)
        HashMap<String, Object> properties
) {}

