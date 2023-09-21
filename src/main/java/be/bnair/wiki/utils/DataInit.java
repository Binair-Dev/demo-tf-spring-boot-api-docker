package be.bnair.wiki.utils;

import be.bnair.wiki.models.entities.WikiEntity;
import be.bnair.wiki.repository.WikiRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements InitializingBean {
    private final WikiRepository wikiRepository;
    public DataInit(WikiRepository wikiRepository) {
        this.wikiRepository = wikiRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //region Création des Wiki
        WikiEntity wiki1 = new WikiEntity();
        wiki1.setTitle("Titre 1 (Singe)");
        wiki1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.");
        wikiRepository.save(wiki1);

        WikiEntity wiki2 = new WikiEntity();
        wiki2.setTitle("Titre 2");
        wiki2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.");
        wikiRepository.save(wiki2);
        //endregion
    }
}