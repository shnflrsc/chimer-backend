package io.shnflrsc.chimer.database;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.mvstore.MVStoreModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Database {
    private final Nitrite db;

    public Database (
            @Value("${nitrite.db.username}") String username,
            @Value("${nitrite.db.password}") String password
    ) {
        MVStoreModule storeModule = MVStoreModule.withConfig()
                .filePath("db/chimer.db")
                .build();

        this.db = Nitrite.builder()
                .loadModule(storeModule)
                .openOrCreate(username, password);
    }

    public Nitrite connect() {
        return db;
    }
}
