--Test data script
INSERT INTO mapping_key_value(mapper_name, number, value) VALUES ('Mapping9', 20, 'tree');
DELETE FROM mapping_key_value WHERE value LIKE 'tree';