package io.shnflrsc.chimer.build;

import io.shnflrsc.chimer.database.Database;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.collection.Document;
import org.dizitart.no2.collection.DocumentCursor;
import org.dizitart.no2.collection.NitriteCollection;
import org.dizitart.no2.common.WriteResult;
import org.springframework.stereotype.Repository;

import static org.dizitart.no2.filters.FluentFilter.where;

@Repository
public class BuildRepository {
    private final Nitrite db;

    public BuildRepository(Database database) {
        db = database.connect();
    }

    public DocumentCursor getAllBuilds() {
        try (
                NitriteCollection builds = db.getCollection("builds")
                ) {
            return builds.find();
        }
    }

    public DocumentCursor getBuildById(String id) {
        try (
                NitriteCollection builds = db.getCollection("builds")
                ) {
            return builds.find(where("id").eq(id));
        }
    }

    public WriteResult create(Build createdBuild) {
        try (
                NitriteCollection builds = db.getCollection("builds")
                ) {
            Document build = Document.createDocument()
                    .put("id", createdBuild.id())
                    .put("timestamp", createdBuild.timestamp())
                    .put("name", createdBuild.name())
                    .put("description", createdBuild.description())
                    .put("properties", createdBuild.properties());

            return builds.insert(build);
        }
    }
}
