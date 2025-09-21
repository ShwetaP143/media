package com.social.media;

import com.social.media.models.SocialGroup;
import com.social.media.models.SocialPost;
import com.social.media.models.SocialProfile;
import com.social.media.models.SocialUser;
import com.social.media.repositories.PostRepository;
import com.social.media.repositories.SocialGroupRepository;
import com.social.media.repositories.SocialProfileRepository;
import com.social.media.repositories.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private PostRepository postRepository;
    private SocialUserRepository socialUserRepository;
    private SocialGroupRepository groupRepository;
    private SocialProfileRepository socialProfileRepository;

    public DataInitializer(PostRepository postRepository, SocialUserRepository socialUserRepository, SocialGroupRepository groupRepository, SocialProfileRepository socialProfileRepository) {
        this.postRepository = postRepository;
        this.socialUserRepository = socialUserRepository;
        this.groupRepository = groupRepository;
        this.socialProfileRepository = socialProfileRepository;
    }

    @Bean
    public CommandLineRunner initializeData(){
        return args -> {
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getSocialUser().add(user1);
            group1.getSocialUser().add(user2);

            group2.getSocialUser().add(user2);
            group2.getSocialUser().add(user3);

            groupRepository.save(group1);
            groupRepository.save(group2);


            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);


            SocialPost post1 = new SocialPost();
            SocialPost post2 = new SocialPost();
            SocialPost post3 = new SocialPost();

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

           //FETCH TYPES
            System.out.println("Fetching Social User");
            socialUserRepository.findById(1L);



        };
    }
}