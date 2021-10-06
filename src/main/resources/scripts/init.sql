CREATE TABLE IF NOT EXISTS web_element_data ( 
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
	web_element_type VARCHAR(300) NOT NULL, 
	web_element_value VARCHAR(300) NOT NULL, 
	web_element_property VARCHAR(300) NOT NULL, 
	CONSTRAINT uniq_webdata UNIQUE (web_element_property));