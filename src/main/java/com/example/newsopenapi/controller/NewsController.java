package com.example.newsopenapi.controller;

import com.example.newsopenapi.service.LiveNewService;
import com.google.gson.Gson;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")

@RestController
public class NewsController {
    private final LiveNewService liveNewService;

    public NewsController(LiveNewService liveNewService)
    {
        this.liveNewService = liveNewService;
    }

    @GetMapping("/news")
    public String getResponse(@RequestParam(required = false) String category) {
        String json = new Gson().toJson(liveNewService.informationReturned(category));
        return json;
    }

    @GetMapping("/news/{id}")
    public String getSpecificResponse(Model model, @PathVariable Integer id) {
        String json = new Gson().toJson(liveNewService.informationReturned(null).getNewsObjectList().get(id));
        return json;
    }
}