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