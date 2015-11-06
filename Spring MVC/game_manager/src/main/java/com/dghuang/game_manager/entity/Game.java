package com.dghuang.game_manager.entity;

import javax.persistence.*;

@Entity
public class Game {
	
	@Id
	@Column
	public String id;
	@Column
	public double cost;
	@Column
	public String company;
	@Column
	public String name;
	
	public Game() {
		
	}
	
}
