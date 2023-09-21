package be.bnair.wiki.models.forms;

import be.bnair.wiki.models.entities.WikiEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class WikiForm {
    @NotEmpty(message = "Le titre ne peut pas être vide.")
    @Size(min = 3, message = "Le titre doit contenir au moins 3 caractères")
    private String title;
    @NotEmpty(message = "La description ne peut pas être vide.")
    @Size(min = 3, message = "La description doit contenir au moins 3 caractères")
    private String description;

    public WikiEntity toEntity() {
        WikiEntity entity = new WikiEntity();
        entity.setTitle(title);
        entity.setDescription(description);
        return entity;
    }
}
