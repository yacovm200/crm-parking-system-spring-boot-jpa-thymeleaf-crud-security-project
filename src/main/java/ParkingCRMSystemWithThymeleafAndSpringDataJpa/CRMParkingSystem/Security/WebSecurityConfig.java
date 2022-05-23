package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
		
		.antMatchers("/home").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")

		.antMatchers("/parkingList").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		.antMatchers("/showFormForAdd").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		.antMatchers("/showFormForUpdate").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		.antMatchers("/save").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		.antMatchers("/delete").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		.antMatchers("/enterToParking").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		.antMatchers("/parking").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		
		.antMatchers("/exit").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		.antMatchers("/exitform").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		.antMatchers("/saveDateAndTimeOfExitParking").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		
		.antMatchers("/search").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
		
		
		.antMatchers("/history").hasAuthority("ROLE_ADMIN")
		.antMatchers("/historyDelete").hasAuthority("ROLE_ADMIN")
		
		.anyRequest().authenticated()
		.and()	
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	// http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll();
	//yacov codejava   admin nimda
}
