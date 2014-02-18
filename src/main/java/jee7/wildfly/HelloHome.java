package jee7.wildfly;

import javax.inject.Named;

import lombok.Getter;

@Named
@Getter
public class HelloHome {

	private String name = "Java EE 7";
}
