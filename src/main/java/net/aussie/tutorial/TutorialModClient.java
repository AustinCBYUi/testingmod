package net.aussie.tutorial;

import net.aussie.tutorial.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //Should be for the bow. Yes it is. Client sided 2D Sprite for bow stretching / changing models.
        ModModelPredicateProvider.registerModModels();
    }
}
