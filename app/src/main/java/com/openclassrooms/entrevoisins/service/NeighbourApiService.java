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

    // gestion des favoris
    /**
     * Get all favorite neighbour
     */

    List<Neighbour> getFavoriteNeighbour();

    Boolean isFavorite(Neighbour neighbour);

    /**
     * Add Favorite Neighbour
     */
    void addFavorite(Neighbour neighbour);

    /**
     * Remove favorite Neighbour
     */
    void removeFavorite(Neighbour neighbour);
}
