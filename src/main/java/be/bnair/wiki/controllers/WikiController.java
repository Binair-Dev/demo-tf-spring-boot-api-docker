package be.bnair.wiki.controllers;

import be.bnair.wiki.models.entities.WikiEntity;
import be.bnair.wiki.models.forms.WikiForm;
import be.bnair.wiki.services.WikiService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/wikis"})
public class WikiController {
    private final WikiService wikiService;

    public WikiController(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @PostMapping(path = {"/create"})
    public ResponseEntity<Object> createAction(
        @RequestBody @Valid WikiForm wikiForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            for(int i = 0; i < bindingResult.getAllErrors().size(); i++) {
                errorList.add(bindingResult.getAllErrors().get(i).getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur, le formulaire n'est pas bon");
        }

        WikiEntity newsEntity = wikiForm.toEntity();
        this.wikiService.create(newsEntity);
        return null;
    }

    @GetMapping(path = {"/list"})
    public List<WikiEntity> findAllAction() {
        return this.wikiService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Object> findByIdAction(@PathVariable Long id) {
        Optional<WikiEntity> wOptional = this.wikiService.getOneById(id);
        if(wOptional.isPresent()) {
            return ResponseEntity.ok().body(wOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Le wiki avec l'ID " + id + " n'existe pas!");
    }
}