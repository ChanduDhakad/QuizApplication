package com.Heliverse.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	private String message;
	private String details;
	private LocalDateTime timestamp;
	
	
	

}
