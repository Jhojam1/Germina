package com.Germina.Germina.api.Controller;

import com.Germina.Germina.domain.Services.ConfigHrService;
import com.Germina.Germina.domain.common.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.API + Routes.ConfigHr.ConfigHr)
public class ConfigHrController {

    @Autowired
    private ConfigHrService configHrService;

    @PutMapping(Routes.ConfigHr.actConfigHr)
    public void updateCutoffTime(@RequestParam String newTime) {
        configHrService.updateCutoffTime(newTime);
    }
}
