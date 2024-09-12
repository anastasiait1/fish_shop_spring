package org.example.freelance_project_overone.controllers;

import org.example.freelance_project_overone.models.ClientModel;
import org.example.freelance_project_overone.models.ItemModel;
import org.example.freelance_project_overone.repos.ClientRepo;
import org.example.freelance_project_overone.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/detailItem")
public class DetailItemController {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ClientRepo clientRepo;

    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable(value = "id") long id, Model model){
        Optional<ItemModel> optional = itemRepo.findById(id);
        List<ItemModel> list = new ArrayList<>();
        optional.ifPresent(list::add);
        model.addAttribute("item", list);
        return "detail";
    }

    @PostMapping("/{id}")
    public RedirectView saveData(@PathVariable(value = "id") long id, @RequestParam String client_name, @RequestParam String contact){
        ClientModel clientModel = new ClientModel();
        clientModel.setClientName(client_name);
        clientModel.setContact(contact);
        clientModel.setWantedItem(String.valueOf(id));
        clientModel.setActual(true);
        clientRepo.save(clientModel);
        return new RedirectView("/");
    }
}
