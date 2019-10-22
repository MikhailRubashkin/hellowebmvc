package by.pvt.security;

import by.pvt.pojo.AppUser;
import by.pvt.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername ( String s) throws UsernameNotFoundException{


        AppUser appUser = appUserRepository.findUserByEmail(s);
        if (appUser == null){
            throw new UsernameNotFoundException ("User not found");
        }

            User user = new User (appUser.getEmail ( ), appUser.getPassword(),
            appUser.getAppRoles ( ).stream ( )
                    .map (appRole -> new SimpleGrantedAuthority (appRole.getRoleName ( ).name ( )))
                    .collect(Collectors.toSet ( )));
            return user;
    }
}
