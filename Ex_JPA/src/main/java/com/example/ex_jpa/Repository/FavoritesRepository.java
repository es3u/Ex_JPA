package com.example.ex_jpa.Repository;

import com.example.ex_jpa.Model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {
}
