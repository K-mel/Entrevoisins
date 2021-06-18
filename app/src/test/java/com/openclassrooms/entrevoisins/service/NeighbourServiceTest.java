package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    //Test pour vérifier que la liste des voisins apparait bien sur la liste principale.

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    // Test supprimer 1 voisin de la liste principale

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    //Test pour vérifier que la liste des favoris n'est pas vide

    @Test
    public void getListFavNeighbourNotEmpty() {
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavorite(neighbour);
        assertFalse(service.getFavoriteNeighbour().isEmpty());
    }


    // Test pour ajouter un voisin dans la liste des favoris

    @Test
    public void addNeighbourToFavoriteWithSuccess(){
        Neighbour neighbouradd = service.getNeighbours().get(0);
        service.addFavorite(neighbouradd);
        assertTrue(service.getFavoriteNeighbour().contains(neighbouradd));
    }

    //Test pour supprimer un voisin de la liste des favoris

    @Test
    public void removeNeighbourToFavoriteWithSuccess(){
        Neighbour neighbourremove = service.getNeighbours().get(0);
        service.addFavorite(neighbourremove);
        assertTrue(service.getFavoriteNeighbour().contains(neighbourremove));
        service.removeFavorite((neighbourremove));
        assertFalse(service.getFavoriteNeighbour().contains(neighbourremove));
    }
}
