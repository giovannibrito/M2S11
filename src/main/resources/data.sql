insert into quiz (id, descricao, nome) values (default, 'Quiz 1', 'Quiz 1');
insert into quiz (id, descricao, nome) values (default, 'Quiz 2', 'Quiz 2');

insert into pergunta (id, texto, titulo, quiz_id) values (default, 'Pergunta 1', 'Pergunta 1', 1);
insert into pergunta (id, texto, titulo, quiz_id) values (default, 'Pergunta 2', 'Pergunta 2', 2);

insert into resposta (id, texto, pergunta_id) values (default, 'Resposta 1', 1);
insert into resposta (id, texto, pergunta_id) values (default, 'Resposta 2', 2);