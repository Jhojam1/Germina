package com.Germina.Germina.api.Controller;

import com.Germina.Germina.domain.Dtos.TempUserDTO;
import com.Germina.Germina.domain.Services.TempUserServices;
import com.Germina.Germina.domain.common.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.API + Routes.TempUser.TempUser)
public class TempUserController {

    @Autowired
    private TempUserServices tempUserServices;

    @PostMapping(value = Routes.TempUser.saveTempUser )
    public TempUserDTO save(@RequestBody TempUserDTO tempUserDTO) {
        return tempUserServices.save(tempUserDTO);
    }

    @GetMapping(value = Routes.TempUser.getTempUser)
    public List<TempUserDTO> get() {
        return tempUserServices.getAll();
    }

    @DeleteMapping(value = Routes.TempUser.deleteTempUser + "/{id}")
    public void delete(@PathVariable Long id) {
        tempUserServices.delete(id);
    }

}
