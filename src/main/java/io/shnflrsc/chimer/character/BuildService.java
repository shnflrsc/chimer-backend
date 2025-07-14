package io.shnflrsc.chimer.character;

import org.dizitart.no2.collection.Document;
import org.dizitart.no2.collection.DocumentCursor;
import org.dizitart.no2.common.WriteResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static io.shnflrsc.chimer.character.BuildUtils.getMap;

@Service
public class BuildService {
    private final BuildRepository repository;

    public BuildService(BuildRepository repository) {
        this.repository = repository;
    }

    public List<Build> getAllBuilds() {
        DocumentCursor cursor = repository.getAllBuilds();
        List<Build> builds = new ArrayList<>();

        for (Document doc : cursor) {
            builds.add(new Build(
                    doc.getId().toString(),
                    doc.get("timestamp", LocalDateTime.class),
                    doc.get("name", String.class),
                    doc.get("description", String.class),
                    getMap(doc, "properties")
            ));
        }

        return builds;
    }

    public WriteResult create(Build createdBuild) {
        return repository.create(createdBuild);
    }
}
