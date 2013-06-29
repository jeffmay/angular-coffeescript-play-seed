# Play (Angular web + Akka api) Seed

I've built this repo as a template for what I think will become a phat stack for multi-project builds.

It comes with:

- a multi-project SBT build using a module structure (this will change slightly with SBT 0.13)
- an API module on top of Play (with an example JSON endpoint)
- a starter Angular project in the web directory on top of Play
  (you should be able to deploy an NGinX server with just the public directory)

## Requirements:

1. Simple build tool (sbt)

    | OS X | Ubuntu |
    | ---- | ------ |
    | brew install sbt | |

2. Node package manager

    | OS X | Ubuntu |
    | ---- | ------ |
    | brew install npm | |

3. CoffeeScript

    | OS X | Ubuntu |
    | ---- | ------ |
    | sudo npm install -g coffee-script | |

## Known Issues:

When you run play from bash command line `play 'web/run'`, you will see an error with the `web/*:play-copy-assets` task.
Thus is because the `root` project is unaware of how to properly call the web project assets. Since I think this is a bug
with SBT, I have decided to leave it alone.

You will also see the error when you run the `web/test` task from the `root` project.
