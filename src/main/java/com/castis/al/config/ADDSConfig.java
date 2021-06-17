package com.castis.al.config;

import java.util.List;


import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Service
public class ADDSConfig {
	private List<String> categoryIdList;
	private List<String> campaignIdList;
}
