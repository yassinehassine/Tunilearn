package Tunilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import Tunilearn.entities.Client;
import Tunilearn.services.IServices;

@RequiredArgsConstructor
@RequestMapping("examen")
@RestController
public class ClientRestController {
    private final IServices services;

    @PostMapping("/add")
    public Client add(@RequestBody Client client){
        return  services.add(client);
    }

}
