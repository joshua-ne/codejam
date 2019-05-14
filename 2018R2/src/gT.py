import random

T = 50000

print(T)

N = 4

for i in range(T):
	print(N)
	for i in range(N):
		for i in range(N):
			print(random.randint(1, 2 * N), end = " ")

		print()
