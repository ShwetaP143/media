package com.social.media.repositories;

import com.social.media.models.SocialPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<SocialPost,Long> {
}
