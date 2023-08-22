package com.graysan.auditing;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@Component // Bu nesne Spring nesnesinin artık bir parçasıdır.
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // DB de giriş yapmış kullanıcı bilgilerini göstermek
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Sisteme girmiş kullanıcı var mı
        if (authentication != null && authentication.isAuthenticated()){
            System.out.println("Sisteme girmiş " + authentication.getName());
            log.info("Sisteme girmiş " + authentication.getName());
            log.info("Sisteme girmiş " + authentication.getPrincipal());
            return Optional.of(authentication.getName());
        }
        return Optional.of("Batuhan Yalcinturk");
    }
}
