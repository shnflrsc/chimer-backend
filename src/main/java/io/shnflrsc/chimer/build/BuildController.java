package io.shnflrsc.chimer.build;

import org.dizitart.no2.common.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BuildController {

    private final BuildService buildService;

    @Autowired
    public BuildController(BuildService buildService) {
        this.buildService = buildService;
    }

    @GetMapping("/builds")
    public ResponseEntity<List<Build>> getAllBuilds() {
        List<Build> builds = buildService.getAllBuilds();
        return new ResponseEntity<>(builds, HttpStatus.OK);
    }

    @GetMapping("/builds/{id}")
    public ResponseEntity<Build> getBuildById (@PathVariable String id) {
        Build build = buildService.getBuildById(id);

        if (build != null) {
            return new ResponseEntity<>(build, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/builds")
    public ResponseEntity<WriteResult> createBuild(@RequestBody Build build) {
        WriteResult result = buildService.create(build);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
