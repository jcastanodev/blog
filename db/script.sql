CREATE TABLE posts (
    post_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE comments (
    comment_id SERIAL PRIMARY KEY,
    post_id INTEGER NOT NULL REFERENCES posts(post_id),
    user_id INTEGER NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    active BOOLEAN DEFAULT TRUE
);

CREATE TABLE post_categories (
    post_id INTEGER NOT NULL REFERENCES posts(post_id),
    category_id INTEGER NOT NULL REFERENCES categories(category_id),
    PRIMARY KEY (post_id, category_id)
);

CREATE TABLE copilot_host (
    copilot_id SERIAL PRIMARY KEY,
    url VARCHAR(255) NOT NULL UNIQUE
);

-- copilot host
INSERT INTO copilot_host (url) VALUES
  ('http://localhost:8099');

-- Categories
INSERT INTO categories (name) VALUES
  ('Tecnología'),
  ('Diseño'),
  ('Marketing'),
  ('Viajes'),
  ('Comida'),
  ('Salud'),
  ('Cine'),
  ('Literatura'),
  ('Música'),
  ('Deportes'),
  ('Hardware'),
  ('Software'),
  ('Redes'),
  ('Ciberseguridad'),
  ('IoT'),
  ('Desarrollo web'),
  ('Desarrollo móvil'),
  ('Desarrollo de juegos'),
  ('DevOps'),
  ('Cloud computing'),
  ('Aprendizaje automático'),
  ('Visión por computadora'),
  ('Procesamiento del lenguaje natural'),
  ('Robótica'),
  ('Ética en la IA');
  
 -- Posts
INSERT INTO posts (user_id, title, content, created_at, updated_at)
VALUES (1, 'Guía de Introducción a Python para Principiantes', 
'<h2>Guía de Introducción a Python</h2><p>Python es uno de los lenguajes de programación más populares hoy en día. En esta guía rápida, te enseñaré los fundamentos básicos de Python, incluyendo variables, bucles y funciones.</p><img src="https://images.unsplash.com/photo-1526379095098-d400fd0bf935?q=80&w=1332&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Python Programming" /><h3>¿Por qué Python?</h3><p>Es fácil de aprender, tiene una comunidad activa y es versátil para diferentes tipos de proyectos.</p>', 
'2024-01-01 12:00:00+00', '2024-01-01 12:00:00+00'),
(1, 'Optimización de Código: Mejores Prácticas para un Código más Eficiente', 
'<h2>Optimización de Código</h2><p>En esta publicación, exploraremos cómo mejorar el rendimiento de tu código con algunas técnicas avanzadas de optimización.</p><img src="https://plus.unsplash.com/premium_photo-1678565999332-1cde462f7b24?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Optimización de Código" /><ul><li>Elimina repeticiones</li><li>Utiliza estructuras de datos adecuadas</li><li>Aprovecha algoritmos eficientes</li></ul>', 
'2024-01-05 10:30:00+00', '2024-01-05 10:30:00+00'),
(1, 'Cómo usar Git y GitHub para Control de Versiones', 
'<h2>Uso de Git y GitHub</h2><p>El control de versiones es crucial para cualquier proyecto de desarrollo de software. Aquí aprenderás a usar <strong>Git</strong> y <strong>GitHub</strong> para gestionar tu código de forma efectiva.</p><img src="https://images.unsplash.com/photo-1618401479427-c8ef9465fbe1?q=80&w=1443&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Git y GitHub" /><p>Empieza por instalar Git y crear tu primer repositorio en GitHub.</p><pre><code>git init<br>git add .<br>git commit -m "Primer commit"</code></pre>', 
'2024-01-10 15:45:00+00', '2024-01-10 15:45:00+00'),
(1, 'Cómo Implementar Pruebas Unitarias en JavaScript', 
'<h2>Pruebas Unitarias en JavaScript</h2><p>Las pruebas unitarias ayudan a garantizar que tu código funciona correctamente. En esta publicación, aprenderás a implementar pruebas unitarias usando <em>Jest</em> en un proyecto de JavaScript.</p><img src="https://plus.unsplash.com/premium_photo-1668487827156-7aa259d7ffa3?q=80&w=1412&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Pruebas Unitarias en JavaScript" /><pre><code>test(''sumar 1 + 2 es igual a 3'', () => {<br> expect(sumar(1, 2)).toBe(3);<br>});</code></pre>', 
'2024-01-15 09:00:00+00', '2024-01-15 09:00:00+00'),
(1, 'Automatización de Tareas con Python: Un Caso de Estudio con Selenium', 
'<h2>Automatización de Tareas con Selenium</h2><p>Automatizar tareas repetitivas puede ahorrarte tiempo y esfuerzo. En este artículo, veremos cómo utilizar Selenium para automatizar acciones en la web utilizando Python.</p><img src="https://images.unsplash.com/photo-1694903110330-cc64b7e1d21d?q=80&w=1332&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Automatización con Selenium" /><p><strong>Instalación de Selenium:</strong></p><pre><code>pip install selenium</code></pre><p>Después, puedes empezar a escribir tus scripts de automatización.</p>', 
'2024-01-20 11:15:00+00', '2024-01-20 11:15:00+00');
