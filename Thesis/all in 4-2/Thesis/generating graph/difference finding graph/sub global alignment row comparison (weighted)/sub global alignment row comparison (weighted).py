import matplotlib.pyplot as plt
x = []
y = []
cnt=0
with open('perecentage_of_identity_frequency_counting_dif.txt') as f:
    for line in f:
        data = line.split()
        cnt+=1
        if cnt <= 1000:
            x.append(-(int(data[0])))
        else:
            x.append((int(data[0])))
        y.append((int(data[1])))

plt.bar(x,y,label='bars',color='r')
plt.xlabel('poi')
plt.ylabel('freq')
plt.title('freq vs poi local alignment (row)')
plt.legend()
plt.show()
