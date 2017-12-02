import matplotlib.pyplot as plt
x = []
y = []

with open('len_vs_poi.txt') as f:
    for line in f:
        data = line.split()
        x.append(int(data[0]))
        y.append(int(data[1]))

plt.bar(x,y)
plt.xlabel('len')
plt.ylabel('poi')
plt.title('poi vs len')
plt.legend()
plt.show()
