package com.Germina.Germina.api.Controller;

import com.Germina.Germina.domain.Services.ConfigHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class ConfigHrController {

    @Autowired
    private ConfigHrService configHrService;

    @PutMapping("/cutoff-time")
    public void updateCutoffTime(@RequestParam String newTime) {
        configHrService.updateCutoffTime(newTime);
    }
}
