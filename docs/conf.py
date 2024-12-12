import os
import sys
sys.path.insert(0, os.path.abspath('..'))

project = 'Your Project Name'
author = 'Your Name'
release = '0.1'

extensions = [
    'sphinx.ext.autodoc',
    'sphinx.ext.napoleon',
    'myst_parser',  # Si vous utilisez Markdown
]

templates_path = ['_templates']
exclude_patterns = []

html_theme = 'alabaster'
html_static_path = ['_static']