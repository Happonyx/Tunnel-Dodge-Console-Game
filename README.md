# Tunnel-Dodge-Console-Game
To experiment with Java threads, I created a Flappy Bird type of console game. Playing as a spaceship, you navigate through a 2D tunnel system as you exponentially accelerate. 

* Important Note: moving inside of a tunnel when invincible breaks the algorithm for tunnel ramming, so I plan on restricting movement inside of a tunnel in the future (if I continue its development).

Features:
- W and S (followed by pressing Enter) control your movement upwards & downwards
- D (followed by pressing Enter) shoots a laser forward to destroy barriers
- Collecting stars gives you 10 seconds of invincibility
- With invincibility, you can ram through pipes
- Goal: get the highest score possible


My original goal with creating this program was to get a better understanding of threads, their limits, and their memory usage. I also wanted to attempt to make a moving 2D background with code, which I was successful at doing. The algorithm for generating the pipes and the path when they're rammed through is quite complicated (and there's 100% no way I could read the code for it) but it works.

Along with this, most of the program is customizable: pipe width, pipe length, pipe gap, border width, star rarity, barrier rarity, etc.

Overall, this program gave me a sense in developing algorithms for logic in generation. I also learned a ton of methods for debugging, such as printing small parts of an algorithm and using test cases instead of rolling completely random generation every time I need to test a pattern.
