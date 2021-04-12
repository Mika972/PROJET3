package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**      ! New list for favorite neighbour     !     */
    private List<Neighbour> favoriteNeighbour = new ArrayList<Neighbour>();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


    /**           {@inheritDoc}*/
    @Override
    public List<Neighbour> getFavoriteNeighbour() {
        return favoriteNeighbour;
    }


    /**           {@inheritDoc}*/
    public void deleteTheFavoriteNeighbour(Neighbour theFavorite) {
        favoriteNeighbour.remove(theFavorite);
    }

    /**           {@inheritDoc}
     *            @param theFavorite */
    @Override
    public void createFavoriteNeighbour(Neighbour theFavorite) {
        favoriteNeighbour.add(theFavorite);
    }
}
