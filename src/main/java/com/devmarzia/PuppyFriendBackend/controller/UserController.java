package com.devmarzia.PuppyFriendBackend.controller;

import com.devmarzia.PuppyFriendBackend.entity.User;
import com.devmarzia.PuppyFriendBackend.repository.UserRepository;
import com.devmarzia.PuppyFriendBackend.service.CloudinaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final CloudinaryService cloudinaryService;

    public UserController(UserRepository userRepository, CloudinaryService cloudinaryService) {
        this.userRepository = userRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/me/upload-photo")
    public ResponseEntity<String> uploadProfilePhoto(@RequestParam("file") MultipartFile file,
                                                     Authentication authentication) {
        // 1. Recupera l'email dell'utente loggato dal Token
        String email = authentication.getName();

        // 2. Trova l'utente nel DB
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        // 3. Carica la foto su Cloudinary
        String imageUrl = cloudinaryService.uploadFile(file);

        // 4. Aggiorna l'utente nel DB con il nuovo URL
        user.setProfileImageUrl(imageUrl);
        userRepository.save(user);

        return ResponseEntity.ok("Foto aggiornata con successo: " + imageUrl);
    }
}