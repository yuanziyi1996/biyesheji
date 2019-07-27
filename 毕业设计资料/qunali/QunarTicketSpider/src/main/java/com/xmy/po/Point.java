package com.xmy.po;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Point implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String lng;

	private String lat;

	private Integer count;

}