package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**  !       return favorite neighbour            !
     *           @return {@link List}               */
    List<Neighbour> getFavoriteNeighbour();


    /**  !       Delete favorite neighbour            !
     *           @param theFavorite                 */
    void deleteTheFavoriteNeighbour(Neighbour theFavorite);

    /**  !       add neighbour in list favorite       !
     *           @param theFavorite                 */
    void createFavoriteNeighbour(Neighbour theFavorite);
}
