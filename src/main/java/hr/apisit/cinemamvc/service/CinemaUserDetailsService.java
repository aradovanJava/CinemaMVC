package hr.apisit.cinemamvc.service;

import hr.apisit.cinemamvc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CinemaUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        hr.apisit.cinemamvc.domain.User user =
                userRepository.findByUsername(username);

        List<SimpleGrantedAuthority> grantedAuthorityList =
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(
                                role.getRoleName()))
                        .toList();

        return new User(user.getUsername(),
                user.getPassword(),
                grantedAuthorityList);
    }
}
