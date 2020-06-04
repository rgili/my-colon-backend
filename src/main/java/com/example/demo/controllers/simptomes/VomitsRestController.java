package com.example.demo.controllers.simptomes;

import com.example.demo.domain.registreSimptomes.Vomits;
import com.example.demo.repositories.registreSimptomes.VomitsRepositori;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vomits")
public class VomitsRestController {

    private VomitsRepositori vomitsRepositori;

    public VomitsRestController(VomitsRepositori vomitsRepositori){
        this.vomitsRepositori = vomitsRepositori;
    }

    @GetMapping("/{usuari}")
    public List<Vomits> getVomitsByUsuari(@PathVariable Integer usuari){
        return this.vomitsRepositori.findAllByUsuariOrderByDataDesc(usuari);
    }

    @PostMapping()
    public void saveVomits(@RequestBody Vomits vomits){
        this.vomitsRepositori.save(vomits);
    }

}
