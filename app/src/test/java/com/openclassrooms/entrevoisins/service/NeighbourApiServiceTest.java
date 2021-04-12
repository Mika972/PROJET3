package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * !Unit test on favorite Neighbour service!
 */
@RunWith(JUnit4.class)
public class NeighbourApiServiceTest {
    /** !Creating a Virtual Neighbor for Unit Testing Purposes
     *  Creation of the new list of favorite neighbor for testing purposes!
     */
    private NeighbourApiService service;
    private Neighbour theFavorite = new Neighbour(13, "Joe", "https://i.pravatar.cc/150?u=a03", "10 rue de l'ile Kotline", "+33 05 89 04 25 81", "j'aime les randonnées dans les régions sauvages");
    private List<Neighbour> expectedFavoriteNeighbours = new ArrayList<Neighbour>();

    @Before
    public void setUp() throws Exception {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void createFavoriteNeighbourWithSuccess() {
        service.createFavoriteNeighbour(theFavorite);
        assertTrue(service.getFavoriteNeighbour().contains(theFavorite));
    }

    @Test
    public void getFavoriteNeighbourWithSuccess() {
        List<Neighbour> favoriteNeighbour = service.getFavoriteNeighbour();
        assertThat(favoriteNeighbour, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavoriteNeighbours.toArray()));
    }

    @Test
    public void deleteTheFavoriteNeighbourWithSuccess() {
        service.createFavoriteNeighbour(theFavorite);
        Neighbour favoriteNeighbourToDelete = service.getFavoriteNeighbour().get(0);
        service.deleteTheFavoriteNeighbour(favoriteNeighbourToDelete);
        assertFalse(service.getFavoriteNeighbour().contains(favoriteNeighbourToDelete));
    }
}