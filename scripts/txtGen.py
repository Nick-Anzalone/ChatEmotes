import os
from resizeimage import resizeimage


directory = r'../src/main/resources/com/twitchEmotes/'
for filename in os.listdir(directory):
    arr = filename.split(".")
    f = open("generated.txt", "a")
    f.write(arr[0].upper()+ '(' + '"' +arr[0].lower() + '"' +  "," + '"' + arr[0] +  '"' + '),' + "\n")

    f.close()


