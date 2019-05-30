package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Actor;
import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.MovieManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.stackroute.spring.jdbc.service.MovieManager;

public class TransactionManagerMain
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		MovieManager movieManager = ctx.getBean("movieManager", MovieManagerImpl.class);
		Movie movie = createDummyMovie();
		movieManager.createMovie(movie);
		ctx.close();
	}
	private static Movie createDummyMovie()
	{
		Movie movie = new Movie();
		movie.setMovieId(4);
		movie.setMovieName("Mohobatein");
		movie.setReleaseYear(1999);
		movie.setRatings(5);
		Actor actor = new Actor();
		actor.setId(5);
		actor.setName("aish");
		actor.setGender("F");
		actor.setAge(30);
		movie.setActor(actor);
		return movie;
	}
}