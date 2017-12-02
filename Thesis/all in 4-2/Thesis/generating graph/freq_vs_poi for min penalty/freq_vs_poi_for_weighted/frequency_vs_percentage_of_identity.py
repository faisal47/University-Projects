import matplotlib.pyplot as plt
x = []
y = []
with open('perecentage_of_identity_frequency_counting.txt') as f:
    for line in f:
        data = line.split()
        x.append(int(data[0]))
        y.append(int(data[1]))

plt.bar(x,y,label='bars',color='r')
plt.xlabel('poi')
plt.ylabel('freq')
plt.title('frq vs poi (from n*n) with weighted edit distance')
plt.legend()
plt.show()
