package io.shnflrsc.chimer.build;

import org.dizitart.no2.collection.Document;
import org.dizitart.no2.collection.DocumentCursor;
import org.dizitart.no2.common.WriteResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static io.shnflrsc.chimer.build.BuildUtils.getMap;

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
                    doc.get("id", String.class),
                    doc.get("timestamp", LocalDateTime.class),
                    doc.get("name", String.class),
                    doc.get("description", String.class),
                    getMap(doc, "properties")
            ));
        }

        return builds;
    }

    public Build getBuildById(String id) {
        DocumentCursor cursor = repository.getBuildById(id);
        Document doc = cursor.firstOrNull();

        if (doc != null) {
            return new Build (
                    doc.get("id", String.class),
                    doc.get("timestamp", LocalDateTime.class),
                    doc.get("name", String.class),
                    doc.get("description", String.class),
                    getMap(doc, "properties")
            );
        } else {
            return null;
        }
    }

    public WriteResult create(Build createdBuild) {
        return repository.create(createdBuild);
    }
}
